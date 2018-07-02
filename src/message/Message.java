package message;

public class Message {
    private StatusMessage statusMessage;
    private PriorityMessage priorityMessage;
    private ValidityMessage validityMessage;

    public Message(StatusMessage statusMessage, PriorityMessage priorityMessage, ValidityMessage validityMessage) {
        setStatusMessage(statusMessage);
        setPriorityMessage(priorityMessage);
        setValidityMessage(validityMessage);
    }

    public void setStatusMessage(StatusMessage statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setPriorityMessage(PriorityMessage priorityMessage) {
        this.priorityMessage = priorityMessage;
    }

    public void setValidityMessage(ValidityMessage validityMessage) {
        this.validityMessage = validityMessage;
    }
}
