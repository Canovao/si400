class MyCustomException extends Exception{
	public static final long serialVersionUID = 424242424242424242L;
	public MyCustomException(String message) {
		super(message);
	}
}
public class Ex5 {

	public static void main(String[] args) {
		try {
			String p = "kddfokmdf";
			if(p != "fadfadf") {
				throw new MyCustomException("Minha exceção está funcionando");
			}
		}catch(MyCustomException w) {
			System.out.print("Erro: "+w.getMessage());
		}

	}

}
