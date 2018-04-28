package com.apress.prospring4.ch3;

public interface ArtworkSender {
    void sendArtwork(String artworkPart, Recipient recipient);
    String getFrendlyName();
    String getShortName();
}
