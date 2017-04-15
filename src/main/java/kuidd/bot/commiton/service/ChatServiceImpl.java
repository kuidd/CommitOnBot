package kuidd.bot.commiton.service;

/**
 * Created by Deys on 11.06.2015.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kuidd.bot.commiton.dao.ChatDAO;
import kuidd.bot.commiton.entity.Chat;

import java.util.List;

@Service
@Transactional
@DependsOn({ "liquibase" })
public class ChatServiceImpl implements ChatService {

    private final Logger log = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    private ChatDAO chatDAO;

    @Override
    public long create(Chat chat) {
        return chatDAO.create(chat);
    }

    @Override
    public Chat update(Chat chat) {
        return chatDAO.update(chat);
    }

    @Override
    public void delete(long id) {
        chatDAO.delete(id);
    }

    @Override
    public List<Chat> getAll() {
        return chatDAO.getAll();
    }

    @Override
    public Chat getOne(long id) {
        return chatDAO.getOne(id);
    }

}