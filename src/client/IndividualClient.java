package client;

import java.net.PasswordAuthentication;

public class IndividualClient extends Client {

    public IndividualClient(PasswordAuthentication passwordAuthentication, String email) {
        super(passwordAuthentication, email);
    }
}
