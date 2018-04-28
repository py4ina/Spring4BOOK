package com.apress.prospring4.ch3;

public class FtpArtworkSender implements ArtworkSender {
    @Override
    public void sendArtwork(String artworkPart, Recipient recipient) {
        System.out.println("Логіка роботи з FTP...");
    }

    @Override
    public String getFrendlyName() {
        return "File Transfer Protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
