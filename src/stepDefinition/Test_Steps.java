package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	public static WebDriver driver;

	private String usuario = "";
	private String contra = "";

//Colores de los mensajes por pantalla
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	

	@Given("^Abrimos navegador$")
	public void abrimos_navegador() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/index.html");
	}

//Login
	@Given("^Introducimos usuario y contrasenia \"([^\"]*)\" y \"([^\"]*)\" para el login$")
	public void introducimos_usuario_y_contrase_a_y_para_el_login(String arg1, String arg2) throws Throwable {

		usuario = arg1;
		contra = arg2;

		driver.get("https://www.saucedemo.com/index.html");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(arg1);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(arg2);
		driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")).click();

	}

//Mensaje login correcto
	@Then("^Login correcto$")
	public void message_displayed_Login_Successfully() throws Throwable {
		try {
			if (driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div")) != null) {
				System.out.println("Login correcto ");
				System.out.println(ANSI_GREEN + usuario + " y " + contra + "\n" + ANSI_RESET);
			}
		} catch (Exception ex) {
			System.out.println("Login incorrecto ");
			System.out.println(ANSI_RED + usuario + " y " + contra + "\n" + ANSI_RESET);
		}

	}

	@Given("^iniciamos_compra$")
	public void iniciamos_compra() throws Throwable {
		try {
//Añadimos la compra al carritod
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[5]/div[3]/button")).click();

//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Vamos al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();

//Espera de 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Volvemos para añadir otro articulo
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[1]")).click();

//Añadimos el segundo articulo al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();

//Espera de 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Volvemos al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();
//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception ex) {
			System.out.println(ANSI_RED + "\nNo se ha podido iniciar sesion con " + usuario + " y " + contra + ANSI_RESET);
		}

	}

//Primer checkout
	@Then("^Checkout$")
	public void confirmamos_compra() throws Throwable {

		try {
//Boton Checkout
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]")).click();

//Espera 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Introduces los datos	
			driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Arturo");
			driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Fernandez");
			driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("28801");

//Boton continuar
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input")).click();

//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Boton finalizar
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]")).click();

//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Logout
			driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button")).click();

//Espera 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

		} catch (Exception ex) {

		}

	}

	@And("^Cerramos navegador$")
	public void cerramos_navegador() throws Throwable {
		driver.close();
	}

	@Given("^iniciamos_segunda_compra$")
	public void iniciamos_segunda_compra() throws Throwable {
		try {
//Añadimos la compra
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/button")).click();

//Añadimos el segundo elemento al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[4]/div[3]/button")).click();

//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Vamos al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();

//Espera de 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Volvemos para añadir otro articulo
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[1]")).click();

//Añadimos el tercer elemento al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();

//Espera de 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Volvemos al carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a")).click();

// Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Borramos un elemento del carrito
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[1]/div[4]/div[2]/div[2]/button")).click();

		} catch (Exception ex) {
			System.out.println(ANSI_RED + "\nNo se ha podido iniciar sesion con " + usuario + " y " + contra + ANSI_RESET);
		}

	}

//Segundo checkout
	@Then("^Checkout_2$")
	public void confirmamos_segunda_compra() throws Throwable {

		try {
//Boton Checkout
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]")).click();

//Espera 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Introduces los datos
			driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Maria");
			driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Ramos");
			driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("24100");

//Boton continuar
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input")).click();

//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Boton finalizar
			driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]")).click();

//Esperamos 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Logout
			driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button")).click();

//Espera 2 segundos
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

		} catch (Exception ex) {
			
		}

	}

}