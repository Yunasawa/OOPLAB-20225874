package hust.soict.dsai.aims;
public class Wrapper<T>
{
	public T Wrapper1;
	public T Wrapper2;
	
	public Wrapper(T wrapper1, T wrapper2)
	{
		Wrapper1 = wrapper1;
		Wrapper2 = wrapper2;
	}
	
	public void Swap()
	{
		T temp = Wrapper1;
		Wrapper1 = Wrapper2;
		Wrapper2 = temp;
	}
}
