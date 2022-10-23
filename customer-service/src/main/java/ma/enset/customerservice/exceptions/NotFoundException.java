package ma.enset.customerservice.exceptions;

public class NotFoundException extends Exception {
    private Long resourceId;
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(Long resourceId) {
        super();
        this.resourceId = resourceId;
    }

    @Override
    public String getMessage() {
        if (resourceId != null)
            return "Element with id '" + resourceId + "' not found";
        return super.getMessage();
    }
}
