package ru.infoza.part4.mail;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mail {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    // ------======== Thief =======---------
    public static class Thief implements MailService {
        private static int StolenValue = 0;
        private static int MinValue = 0;

        public Thief(int m) {
            MinValue = m;
        }

        public int getStolenValue() {
            return StolenValue;
        }
        @Override
        public Sendable processMail(Sendable mail) {
            if ( mail instanceof MailPackage ) {
                Package p = ((MailPackage) mail).getContent() ;
                if ( p.getPrice() >= MinValue ) {
                    StolenValue += p.getPrice() ;
                    return new MailPackage( mail.getFrom() , mail.getTo() , new Package ( "stones instead of " + p.getContent() , 0 ) ) ;
                }
            }
            return mail;
        }

    }


    // ------======== Spy =======---------
    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(Logger l) {
            logger = l;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage newMailMessage = (MailMessage) mail;
                String logMessage;
                if (newMailMessage.getFrom().equals(AUSTIN_POWERS) || newMailMessage.getTo().equals(AUSTIN_POWERS)) {
                    logMessage = String.format("Detected target mail correspondence: from %s to %s \"%s\"",
                            newMailMessage.getFrom(),
                            newMailMessage.getTo(),
                            newMailMessage.getMessage()
                    );
                    logger.log(Level.WARNING,logMessage);
                } else {
                    logMessage = String.format("Usual correspondence: from %s to %s",
                            newMailMessage.getFrom(),
                            newMailMessage.getTo()
                    );
                    logger.log(Level.INFO,logMessage);
                }

            }
            return mail;
        }
    }

    // ------======== Inspector =======---------
    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }

        public IllegalPackageException (String message) {
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }

        public StolenPackageException (String message) {
        }
    }

    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailPackage){
                MailPackage newMailPackage = (MailPackage) mail;
                if(newMailPackage.getContent().getContent().contains(BANNED_SUBSTANCE) || newMailPackage.getContent().getContent().contains(WEAPONS)){
                    throw new IllegalPackageException();
                } else if(newMailPackage.getContent().getContent().contains("stones")){
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    // ------======== Ненадёжный сотрудник =======---------
    public static class UntrustworthyMailWorker implements MailService {
        private static MailService[] workers;
        private static RealMailService realWorker = new RealMailService();

        public UntrustworthyMailWorker (MailService[] w){
            workers = w;
        }

        public MailService getRealMailService() {
            return realWorker;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable processed = mail;
            for (int i = 0; i < workers.length; i++) {
                processed = workers[i].processMail(processed);
            }
            return realWorker.processMail(processed);
        }
    }
}

