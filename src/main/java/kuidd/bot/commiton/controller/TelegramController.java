package kuidd.bot.commiton.controller;

/**
 * Created by Deys on 11.06.2015.
 */

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kuidd.bot.commiton.manager.TelegramManager;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("telegram")
public class TelegramController {

    private final Logger log = LoggerFactory.getLogger(TelegramController.class);

    @Autowired
    private TelegramManager telegramManager;

    @RequestMapping(value = {"/commands"})
    public String getCommands(Model model) {

        List<String> list = new ArrayList<>();
        list.add(telegramManager.getUpdates());

        model.addAttribute("list", list);

        return "telegram/commands";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/send", method = RequestMethod.GET , produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String send(@RequestParam("text") String text) {
        String result = "false";
        String error = "";
        JSONObject jsonObject = new JSONObject();
        try {
            telegramManager.sendMessage(text);
            result = "true";
        } catch (Exception e) {
            error = e.getMessage();
            log.error(error);
        }
        jsonObject.put("result", result);
        jsonObject.put("error", error);

        return jsonObject.toJSONString();
    }
}
