<?php 
$mt=0;
if(isset($_POST['montant'])){
    $mt=$_POST['montant'];
    $clientSOAP=new SoapClient("http://localhost:9191/WS/BanqueWS?WSDL");
    $param=new stdClass();
    $param->montant=$mt;
    $res=$clientSOAP->__soapCall("conversionEuroToDH",array($param));
}
?>
<html>
    <body>
        <form action="banque.php" method="post">
            Montant: <input type="text" name="montant" value="<?php echo($mt)?>">
            <input type="submit" value="OK">
        </form>
        <?php if(isset($res)) {?>
        <?php echo($mt) ?>en Euro = <?php echo($res->return)?> en DH
        <?php }?>
    </body>
</html>