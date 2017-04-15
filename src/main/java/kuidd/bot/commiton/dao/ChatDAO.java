package kuidd.bot.commiton.dao;

import kuidd.bot.commiton.entity.Chat;

import java.util.List;

public interface ChatDAO {

    long create(Chat chat);

    Chat update(Chat chat);

    void delete(long id);

    List<Chat> getAll();

    Chat getOne(long id);

}
