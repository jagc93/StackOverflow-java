package question_494578;

public class Ciudades {

	private String nomCiudad;
	private String pais;

	void setNomCiudad (String C)
	{    nomCiudad=C; }  

	String getNomCiudad()
	{    return nomCiudad;}  

	void setPais (String P)
	{    pais=P; }  

	String getPais()
	{    return pais;}  

	public void mensaje(String m1,String m2)
	{
		System.out.println(m1+" es una ciudad que queda en "+m2);
	}
	Ciudades () 
	{
		System.out.println ( "\"Ciudades del mundo\"" );
	}
}
