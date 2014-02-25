package com.helloword.protocolTransmission;

import com.google.gson.Gson;
import com.helloword.gsonObject.responseProtocol.gameProtocol.AnswersResponseProtocol;
import com.helloword.gsonObject.responseProtocol.gameProtocol.DroppedOutResponseProtocol;
import com.helloword.gsonObject.responseProtocol.gameProtocol.PuzzlesResponseProtocol;
import com.helloword.gsonObject.responseProtocol.gameProtocol.RankResponseProtocol;

public class DeserializeGameResponse {

    public AnswersResponseProtocol answersResponse(String jsonData) {
        AnswersResponseProtocol responseData = new AnswersResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, AnswersResponseProtocol.class);
        return responseData;        
    }

    public  PuzzlesResponseProtocol puzzlesResponse(String jsonData) {
        PuzzlesResponseProtocol responseData = new PuzzlesResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, PuzzlesResponseProtocol.class);
        return responseData;
    }

    public RankResponseProtocol rankResponse(String jsonData) {
        RankResponseProtocol responseData = new RankResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, RankResponseProtocol.class);
        return responseData;
    }

    public DroppedOutResponseProtocol droppedOutResponse(String jsonData) {
        DroppedOutResponseProtocol responseData = new DroppedOutResponseProtocol();
        Gson gson = new Gson();
        responseData = gson.fromJson(jsonData, DroppedOutResponseProtocol.class);
        return responseData;
    }
}
