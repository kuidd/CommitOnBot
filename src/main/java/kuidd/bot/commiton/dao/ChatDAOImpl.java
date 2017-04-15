package kuidd.bot.commiton.dao;

/**
 * Created by Deys on 11.06.2015.
 */

import kuidd.bot.commiton.entity.Chat;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class ChatDAOImpl implements ChatDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Chat chat) {
        Serializable id = sessionFactory.getCurrentSession().save(chat);
        return (Long)id;
    }

    @Override
    public Chat update(Chat chat) {
        sessionFactory.getCurrentSession().update(chat);
        return chat;
    }

    @Override
    public void delete(long id) {
        Chat chat = new Chat();
        chat.setId(id);
        sessionFactory.getCurrentSession().delete(chat);
    }

    @Override
    public List<Chat> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Chat e");

        return query.list();
    }

    @Override
    public Chat getOne(long id) {
        return (Chat)sessionFactory.getCurrentSession().get(Chat.class, id);
    }

}
