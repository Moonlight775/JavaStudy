package section16.objectStream;

import java.io.Serializable;

public class Data implements Serializable{ //����ȭ
	public static final long serversionUID=10l; //��ġȭ
	
	String id;
	String command;
	String msg;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
