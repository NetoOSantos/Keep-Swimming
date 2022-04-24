package com.mycompany.swing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class KeepSwimming_TelegramBot extends TelegramLongPollingBot  {

    private String token = DadosBot.BOT_TOKEN;
    
    
    private Boolean seila;

    public KeepSwimming_TelegramBot(Boolean seila) {
        this.seila = seila;
    }
    

    @Override
    public String getBotUsername() {
        return DadosBot.BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return DadosBot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            var mensagem = responder(update);
            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage responder(Update update) {
        var textoMensagem = update.getMessage().getText().toLowerCase();
        var chatId = update.getMessage().getChatId().toString();

        var resposta = "";
      
        Integer enviaCodigo = ThreadLocalRandom.current().nextInt(1000, 5000);
        String codigoFormatado = enviaCodigo.toString();
             
        
        if ("/data".equals(textoMensagem)) {
            resposta = getData();
        }else if (textoMensagem.startsWith("/token")) {
            resposta = codigoFormatado;
        } else if (textoMensagem.startsWith("/hora")) {
            resposta = getHora();
        } else if (textoMensagem.startsWith("ola") || textoMensagem.startsWith("olá") || textoMensagem.startsWith("/oi")) {
            resposta = "Olá, Bem vindo a Keep Swimming!\nComo podemos te ajudar?!😉";
        } else if (textoMensagem.startsWith("quem é você") || textoMensagem.startsWith("quem e voce")) {
            resposta = "\uD83E\uDD16 Somos uma empresa de monitoramento de monitoramento de hardaware e IDES!!\nPara mais informaçoes acesse nosso site!😉\n http://www.localhost:3333/";
        } else if (textoMensagem.startsWith("/help")) {
            resposta = "Utilize um dos comandos:\nolá\ndata\nhora\nquem é você?";
        } else {
            resposta = "Não entendi!\nDigite /help para ver os comandos disponíveis.";
        }

        return SendMessage.builder()
                .text(resposta)
                .chatId(chatId)
                .build();
    }

    private String getData() {
        var formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "A data atual é: " + formatter.format(new Date());
    }

    private String getHora() {
        var formatter = new SimpleDateFormat("HH:mm:ss");
        return "A hora atual é: " + formatter.format(new Date());
    }

    
    
   
    public static void sendToTelegram() {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        //Telegram token 
        String apiToken = "5226424793:AAEqECvlTAc_63u7hl702KBKS5HiF7PHrmE";
      
        //chatId 
        String chatId = "-667290625";
        //Message
        String text = "Olá, Bem vindo a Keep Swimming!.Como podemos te ajudar?!😉";

        urlString = String.format(urlString, apiToken, chatId, text);
        System.out.println("\nEnviamos uma mensagem a essa url com sucesso = "+ urlString);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendToTelegramToken(String txt) {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        //Telegram token 
        String apiToken = "5226424793:AAEqECvlTAc_63u7hl702KBKS5HiF7PHrmE";
      
        //chatId 
        String chatId = "-667290625";
        //Message
        String text = String.format("Seu token é: %s .Se você nao solicitou entre em contanto imediantamente conosco!!", txt);

        urlString = String.format(urlString, apiToken, chatId, text);
        System.out.println("\nEnviamos uma mensagem a essa url com sucesso = "+ urlString);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
