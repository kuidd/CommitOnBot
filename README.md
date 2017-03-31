# CommitOnBot

Telegram Bot для уведомления об изменениях в репозиториях.

Инструкция по тестовому запуску:
1. Запустить проект из Eclipse, как Java Application.
1.1. Проект запустит и Telegram-бота и HTTP-сервер.
2. В качестве main-метода указать kuidd.tests.TestMain.main.
3. В приложении Telegram найти бота CommitOnBot.
4. Подписаться на обновления командой /subscribe.
5. В браузере открыть тестовую страницу http://localhost:7777/test.
6. В открывшейся странице нажать кнопку "send".
7. В Telegram от бота придёт сообщение "Dmitry Usynin commited on CommitOnBot".

API бота:
/start - бот сообщит статус подписки и предложит изменить его
/help - бот сообщит команды для активации и отмены подписки
/subscribe - активировать подписку
/unsubscribe - отменить подписку
