import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
/*

 * *Nombre de los programadores:  Darío Verdezoto
 * *Materia: Programacion 2
 * *Fecha: 22/05/2024
 * *Detalle: Numero Perfecto
 * *Version: 1
 */

@WebServlet("/Servlet")

public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    //Para llamar y cambiar a tipo int ya que
        //era texto
    int numero = Integer.parseInt(req.getParameter("numero"));
    //Vamos a llamar a la funcion para verificar si es perfecto o no
    boolean Perfecto=Perfectonumero(numero);
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.printf("<meta charset=\"utf-8\">");
        out.printf("<title> Hola Mundo </title>");
        out.print("</head>");
        out.print("<body>");
        if (Perfecto){

            resp.getWriter().println("<h1>El numero es Perfecto<br>"+numero+"</h1>");
        }else{
            resp.getWriter().println("<h1>El numero no es Perfecto<br>"+numero+"</h1>");
        }

        out.print("</body>");
        out.print("</html>");
    }
    // Va  tomar como parametro y lo que va a devolver es un booleano siendo perfecto o no
    protected boolean Perfectonumero(int numero){
        //Va a tomar de inicio el numero 1 ya que todos
        //son divisibles para 1
        int acum = 1;
        //El bucle for va a inicializar en 2
        for (int i = 2; i <numero; i++) {
            //En este paso el numero ingresado va a verificar
            //si esque es o no divisible para el i actual
            //que es "2"
            if (numero % i == 0) {
                //Si el resultado de la division llega a 0
                //se va a acumular
                acum += i;
            }
        }
        //Si el numero ingresado llega a ser igual
        //al valor de las divisiones va a retornar
        //con Un True
        //Numeros Perfectos:6,28,496,8128
        return acum == numero;
    }
}
