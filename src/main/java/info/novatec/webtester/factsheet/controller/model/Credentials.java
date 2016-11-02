package info.novatec.webtester.factsheet.controller.model;

public class Credentials {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static CredentialsBuilder builder() {
        return new CredentialsBuilder();
    }

    public static final class CredentialsBuilder {
        private String username;
        private String password;

        private CredentialsBuilder() {
        }

        public CredentialsBuilder username(String username) {
            this.username = username;
            return this;
        }

        public CredentialsBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Credentials build() {
            Credentials credentials = new Credentials();
            credentials.setUsername(username);
            credentials.setPassword(password);
            return credentials;
        }

    }

}
