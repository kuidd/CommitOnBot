package kuidd.bot.commiton.service;

/**
 * Created by Deys on 11.06.2015.
 */
import kuidd.bot.commiton.entity.Chat;

import java.util.List;

public interface ChatService {

    long create(Chat chat);

    Chat update(Chat chat);

    void delete(long id);

    List<Chat> getAll();

    Chat getOne(long id);

}
