package oms.Calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JButton boton0;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton botonDecimal;
	private JButton botonDivision;
	private JButton botonMultiplicacion;
	private JButton botonResta;
	private JButton botonSuma;
	private JButton BotonResultado;
	private JButton BotonLimpiar;
	private JButton botonEliminarDigito;
	private JButton botonCambioSigno;
	private JLabel lblMuestra;

	private double operador1;
	private double operador2;
	private String operacion;

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boton0 = new JButton("0");
		boton0.setBounds(109, 328, 79, 79);
		boton0.addActionListener(numeros);
		contentPane.add(boton0);
		
		boton1 = new JButton("1");
		boton1.setBounds(29, 247, 79, 79);
		boton1.addActionListener(numeros);
		contentPane.add(boton1);
		
		boton2 = new JButton("2");
		boton2.setBounds(109, 247, 79, 79);
		boton2.addActionListener(numeros);
		contentPane.add(boton2);
		
		boton3 = new JButton("3");
		boton3.setBounds(189, 247, 79, 79);
		boton3.addActionListener(numeros);
		contentPane.add(boton3);
		
		boton4 = new JButton("4");
		boton4.setBounds(29, 167, 79, 79);
		boton4.addActionListener(numeros);
		contentPane.add(boton4);
		
		boton5 = new JButton("5");
		boton5.setBounds(109, 167, 79, 79);
		boton5.addActionListener(numeros);
		contentPane.add(boton5);
		
		boton6 = new JButton("6");
		boton6.setBounds(189, 167, 79, 79);
		boton6.addActionListener(numeros);
		contentPane.add(boton6);

		boton7 = new JButton("7");
		boton7.setBounds(29, 87, 79, 79);
		boton7.addActionListener(numeros);
		contentPane.add(boton7);
		
		boton8 = new JButton("8");
		boton8.setBounds(109, 87, 79, 79);
		boton8.addActionListener(numeros);
		contentPane.add(boton8);
		
		boton9 = new JButton("9");
		boton9.setBounds(189, 87, 79, 79);
		boton9.addActionListener(numeros);
		contentPane.add(boton9);

		botonDecimal = new JButton(".");
		botonDecimal.setBounds(189, 328, 79, 79);
		botonDecimal.addActionListener(numeros);
		contentPane.add(botonDecimal);
		
		botonDivision = new JButton("/");
		botonDivision.setBounds(285, 87, 79, 79);
		botonDivision.addActionListener(operadores);
		contentPane.add(botonDivision);
		
		botonMultiplicacion = new JButton("*");
		botonMultiplicacion.setBounds(285, 167, 79, 79);
		botonMultiplicacion.addActionListener(operadores);
		contentPane.add(botonMultiplicacion);
		
		botonResta = new JButton("-");
		botonResta.setBounds(285, 247, 79, 79);
		botonResta.addActionListener(operadores);
		contentPane.add(botonResta);
		
		botonSuma = new JButton("+");
		botonSuma.setBounds(285, 328, 79, 79);
		botonSuma.addActionListener(operadores);
		contentPane.add(botonSuma);
		
		BotonResultado = new JButton("=");
		BotonResultado.setBounds(369, 328, 79, 79);
		BotonResultado.addActionListener(operadores);
		contentPane.add(BotonResultado);
		
		BotonLimpiar = new JButton("C");
		BotonLimpiar.setBounds(369, 167, 79, 79);
		BotonLimpiar.addActionListener(operadores);
		contentPane.add(BotonLimpiar);
		
		botonEliminarDigito = new JButton("<-");
		botonEliminarDigito.setBounds(369, 87, 79, 79);
		botonEliminarDigito.addActionListener(operadores);
		contentPane.add(botonEliminarDigito);
		
		botonCambioSigno = new JButton("+/-");
		botonCambioSigno.setBounds(29, 328, 79, 79);
		botonCambioSigno.addActionListener(operadores);
		contentPane.add(botonCambioSigno);
		
		lblMuestra = new JLabel("0");
		lblMuestra.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMuestra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMuestra.setOpaque(true);
		lblMuestra.setBackground(new Color(255, 255, 255));
		lblMuestra.setBounds(29, 28, 419, 48);
		contentPane.add(lblMuestra);
		
		operador1=0;
		operador2=0;
		operacion="";
		
		setLocationRelativeTo(null);
	}

	ActionListener numeros= new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            addNumero(e);
        }
    };
	
	ActionListener operadores= new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            addOperador(e);
        }
    };
    
    public void addNumero(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(lblMuestra.getText().equals("+") || lblMuestra.getText().equals("-") 
        		|| lblMuestra.getText().equals("*") || lblMuestra.getText().equals("/") 
        		|| lblMuestra.getText().equals("0") || lblMuestra.getText().equals("0.0"))
        	lblMuestra.setText("");
        lblMuestra.setText(lblMuestra.getText()+button.getText());
    }

    public void addOperador(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch(button.getText()) {
        	case "+":
        		lblMuestra.setText(sumar());
        		break;
        	case "-":
        		lblMuestra.setText(restar());
        		break;
        	case "*":
        		lblMuestra.setText(multiplicar());
        		break;
        	case "/":
        		lblMuestra.setText(dividir());
        		break;
        	case "+/-":
        		lblMuestra.setText(cambiarSigno());
        		break;
        	case "<-":
        		lblMuestra.setText(eliminarDigito());
        		break;
        	case "C":
            	lblMuestra.setText(limpiarCalculadora());
        		break;
        	case "=":
        		lblMuestra.setText(operar());
        		break;
        }
    }
    
    public String sumar() {
    	operador1 = Double.parseDouble(lblMuestra.getText());
    	operacion = "+";
    	return "+";
    }

    public String restar() {
    	operador1 = Double.parseDouble(lblMuestra.getText());
    	operacion = "-";
    	return "-";
    }

    public String multiplicar() {
    	operador1 = Double.parseDouble(lblMuestra.getText());
    	operacion = "*";
    	return "*";
    }

    public String dividir() {
    	operador1 = Double.parseDouble(lblMuestra.getText());
    	operacion = "/";
    	return "/";
    }

    public String cambiarSigno() {
    	double num_actual = Double.parseDouble(lblMuestra.getText());
    	num_actual*=-1;
    	return (String.valueOf(num_actual));
    }
    
    public String eliminarDigito() {
    	return (lblMuestra.getText().substring(0, lblMuestra.getText().length()-1));
    }

    public String limpiarCalculadora() {
    	operador1 = 0;
    	operador2 = 0;
    	operacion = "";
    	return "0";
    }

    public String operar() {
    	operador2 = Double.parseDouble(lblMuestra.getText());
    	String resultado = "";
    	switch(operacion) {
    		case "+":
    			resultado = (String.valueOf(operador1+operador2));
    			break;
    		case "-":
    			resultado = (String.valueOf(operador1-operador2));
    			break;
    		case "*":
    			resultado = (String.valueOf(operador1*operador2));
    			break;
    		case "/":
    			resultado = (String.valueOf(operador1/operador2));
    			break;
	    }
    	
    	return resultado;
    }

}
