package kuidd.bot.commiton.scheduler;

/**
 * Created by Deys on 11.06.2015.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import kuidd.bot.commiton.manager.TelegramManager;

@Service
public class TelegramScheduler {

    private final Logger log = LoggerFactory.getLogger(TelegramScheduler.class);

    @Autowired
    private TelegramManager telegramManager;

    @Scheduled(cron = "0 0 9 * * *")
    public void goWork()
    {
        telegramManager.sendMessage("� ��� �������! ��� ���?");
    }

    @Scheduled(cron = "0 0 16 * * *")
    public void tea()
    {
        telegramManager.sendMessage("����� ���.");
    }

    @Scheduled(cron = "0 30 16 * * *")
    public void support()
    {
        telegramManager.sendMessage("���� ������ support");
    }

    @Scheduled(cron = "0 0 18 * * *")
    public void goHome()
    {
        telegramManager.sendMessage("��������� ���� ����");
    }

    @Scheduled(cron = "0 0 19 * * *")
    public void sashaGoHome()
    {
        telegramManager.sendMessage("����, ��� �����!");
    }

}