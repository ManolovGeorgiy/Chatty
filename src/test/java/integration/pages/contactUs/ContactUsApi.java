package integration.pages.contactUs;

import java.util.Scanner;

public class ContactUsApi {
    public void sendMessageFeedback(String userName, String userEmail, String userMessage) {
    }

    public static void sendMessage(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContactUsApi contactUsApi = new ContactUsApi();
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();

        System.out.println("Please enter your email:");
        String userEmail = scanner.nextLine();

        System.out.println("Please enter your message:");
        String userMessage = scanner.nextLine();

        contactUsApi.sendMessageFeedback(userName, userEmail, userMessage);

        scanner.close();
    }
}