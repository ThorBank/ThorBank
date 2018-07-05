package message;

public class Message {
    //TODO: string message
    private StatusMessage statusMessage;
    private PriorityMessage priorityMessage;
    private ValidityMessage validityMessage;

    public Message(final StatusMessage statusMessage, final PriorityMessage priorityMessage, final ValidityMessage validityMessage) {
        setStatusMessage(statusMessage);
        setPriorityMessage(priorityMessage);
        setValidityMessage(validityMessage);
    }

    public void setStatusMessage(final StatusMessage statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setPriorityMessage(final PriorityMessage priorityMessage) {
        this.priorityMessage = priorityMessage;
    }

    public void setValidityMessage(final ValidityMessage validityMessage) {
        this.validityMessage = validityMessage;
    }

    public StatusMessage getStatusMessage() {
        return statusMessage;
    }

    public PriorityMessage getPriorityMessage() {
        return priorityMessage;
    }

    public ValidityMessage getValidityMessage() {
        return validityMessage;
    }
}
