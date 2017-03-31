package kuidd;

public class Bot implements IBot {

	private IChats chats = new Chats();

	@Override
	public void help(IChat chat) {
		chat.print("��������� �������:\n/subscribe - �����������\n/unsubscribe - ����������");
	}

	@Override
	public void start(IChat chat) {
		if (chats.exists(chat)) {
			chat.print("�������� ��� ������������.\n/unsubscribe - ����������");
		} else {
			chat.print("�������� ��� �� ������������.\n/subscribe - �����������");
		}
	}

	@Override
	public void subscribe(IChat chat) {
		chats.add(chat);
		chat.print("�������� ������������.");
	}

	@Override
	public void unsubscribe(IChat chat) {
		chats.remove(chat);
		chat.print("�������� ��������.");
	}

	@Override
	public void broadcast(ICommit commit) {
		chats.broadcast(commit);
	}

}
