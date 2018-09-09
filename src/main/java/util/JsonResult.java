package util;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable{

	public static final int SUCCESS = 0;
	public static final int ERROR = 1;

	private int state;
	/** 错误消息  */
	private String message;
	/** 返回正确时候的数据 */
	private Object data;

	public JsonResult() {
	}

	public JsonResult(Object data){
		state = SUCCESS;
		this.data = data;
	}

	public JsonResult(Throwable e) {
		state = ERROR;
		message = e.getMessage();
	}

	public JsonResult(int state, Throwable e) {
		this.state = state;
		this.message = e.getMessage();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
