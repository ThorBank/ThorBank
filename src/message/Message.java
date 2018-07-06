package message;

public class Message {
    private String text;
    private StatusMessage statusMessage;
    private PriorityMessage priorityMessage;
    private ValidityMessage validityMessage;
    private Sender sender;

    public Message(final String text, final StatusMessage statusMessage, final PriorityMessage priorityMessage, final ValidityMessage validityMessage, final Sender sender) {
        setStatusMessage(statusMessage);
        setPriorityMessage(priorityMessage);
        setValidityMessage(validityMessage);
        this.sender = sender;
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
