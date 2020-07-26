package net.wozi.ecommerce.productsvc.services;

import java.util.concurrent.ThreadLocalRandom;

public class MessageService {

    public String getMessage(){
        int msgNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        String message;
        switch(msgNum) {
            case 1:
                message = "A message from Sally";
                break;
            case 2:
                message = "Stupid message from Bob";
                break;
            case 3:
                message = "Unknown message from Janet";
                break;
            case 4:
                message = "No one here right now";
                break;
            case 5:
                message = "Hey....Wat up.....";
                break;
            case 6:
                message = "Bugs Bunny was here and there";
                break;
            case 7:
                message = "Today is a new day for everyone";
                break;
            case 8:
                message = "What is your quest.....";
                break;
            case 9:
                message = "Have you seen Sally lately??";
                break;
            case 10:
                message = "Does anyone really know what time it is.....";
                break;
            default:
                message="null and void";
        }
        return message;
    }

    public static void main(String[]args){
        MessageService app = new MessageService();
        for (int msg=0; msg<100; msg++){
            System.out.println("["+msg+"] = " + app.getMessage());
        }
    }
}
