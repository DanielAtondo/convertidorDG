import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

class VentanaPrograma extends JFrame implements ActionListener{

public JPanel panelPrincipal;

				JButton convertir, refrescar;

				JTextField intro;

				JLabel hexa, decimal, octal, binario, titulo, subtitulo;

				JSpinner sistemas;
				String sistemasNumericos [] = {"Binario","Octal", "Decimal", "Hexadecimal"};

	public VentanaPrograma()
	{
		titulo = new JLabel("Convertidor de sistemas numericos");
		titulo.setBounds(200,200,1900,100);
		titulo.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 80));
		subtitulo = new JLabel("<html>Atondo Gastelum Oliver Daniel <br/> Lorenzana Belli Ivan <br/> Sanchez Sanchez Tabatha Fabiola <br/> Talavera Perez Fernanda <br/> Vargas Rodriguez Angel Jovan</html>");
		subtitulo.setBounds(200,310,1200,130);
		subtitulo.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 20));
		binario = new JLabel("Bin: ");
		binario.setBounds(200,500,600,40);
		binario.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		octal = new JLabel("Dec: ");
		octal.setBounds(200,550,600,40);
		octal.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		decimal = new JLabel("Oct: ");
		decimal.setBounds(200,600,600,40);
		decimal.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		hexa = new JLabel("Hex: ");
		hexa.setBounds(200,650,600,40);
		hexa.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		sistemas = new JSpinner(new SpinnerListModel(sistemasNumericos));
		sistemas.setBounds(910,450,280,40);
		sistemas.setVisible(true);
		sistemas.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		panelPrincipal = new JPanel(null);
		JTextField intro = new JTextField();
		intro.setBounds(200,450,700,40);
		intro.setEditable(true);
		intro.setVisible(true);
		intro.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		convertir = new JButton("Convertir");
		convertir.setBounds(1200,450,120,40);
		convertir.setFont(new Font("BebasNeue-Regular.ttf", Font.PLAIN, 24));
		convertir.setForeground(Color.white);
		convertir.setBackground(Color.black);
		convertir.setOpaque(true);
		convertir.setContentAreaFilled(true);
		convertir.setBorder(null);
		convertir.setHorizontalAlignment(SwingConstants.CENTER);
		convertir.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
		 if (sistemas.getValue().equals("Binario")){
			 binario.setText("Bin: "+(conversionUniversal(conversionDecimal(intro.getText(),2),2)));
			 octal.setText("Oct: "+(conversionUniversal(conversionDecimal(intro.getText(),2),8)));
		   decimal.setText("Dec: "+(conversionUniversal(conversionDecimal(intro.getText(),2),10)));
       hexa.setText("Hex: "+(conversionUniversal(conversionDecimal(intro.getText(),2),16)));
		 }
		 else if (sistemas.getValue().equals("Octal")){
			 binario.setText("Bin: "+(conversionUniversal(conversionDecimal(intro.getText(),8),2)));
			 octal.setText("Oct: "+(conversionUniversal(conversionDecimal(intro.getText(),8),8)));
		   decimal.setText("Dec: "+(conversionUniversal(conversionDecimal(intro.getText(),8),10)));
       hexa.setText("Hex: "+(conversionUniversal(conversionDecimal(intro.getText(),8),16)));
		 }else if (sistemas.getValue().equals("Decimal")){
			 binario.setText("Bin: "+(conversionUniversal(conversionDecimal(intro.getText(),10),2)));
			 octal.setText("Oct: "+(conversionUniversal(conversionDecimal(intro.getText(),10),8)));
		   decimal.setText("Dec: "+(conversionUniversal(conversionDecimal(intro.getText(),10),10)));
       hexa.setText("Hex: "+(conversionUniversal(conversionDecimal(intro.getText(),10),16)));
		 }
		 else if (sistemas.getValue().equals("Hexadecimal")){
			 binario.setText("Bin: "+(conversionUniversal(conversionDecimal(intro.getText(),16),2)));
			 octal.setText("Oct: "+(conversionUniversal(conversionDecimal(intro.getText(),16),8)));
		   decimal.setText("Dec: "+(conversionUniversal(conversionDecimal(intro.getText(),16),10)));
       hexa.setText("Hex: "+(conversionUniversal(conversionDecimal(intro.getText(),16),16)));
		 }
	 }
});

		panelPrincipal.add(convertir);
		panelPrincipal.add(sistemas);
		panelPrincipal.add(intro);
		panelPrincipal.add(sistemas);
		panelPrincipal.add(binario);
		panelPrincipal.add(octal);
		panelPrincipal.add(decimal);
		panelPrincipal.add(hexa);
		panelPrincipal.add(titulo);
		panelPrincipal.add(subtitulo);
		this.add(panelPrincipal);

				this.setTitle("CONVERTIDOR DE SISTEMAS");
				this.setBounds(100,100,1700,900);
			//	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//	this.setUndecorated(true);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setVisible(true);
				this.setLayout(null);

				panelPrincipal.setBounds(0,0,1700,700);
			}

			public void actionPerformed(ActionEvent event)
			{
				System.out.println("Hola");
			}

			public int conversionDecimal(String entro, int base)
			{
				int suma;
				int resultado = 0;
				for (int i = 0; i < entro.length(); i++) {
				suma = ((Character.getNumericValue(entro.charAt((entro.length())-1-i)))*( (int) Math.pow(base,i)));
				resultado = resultado + suma;
				}
				return resultado;
			}

			public String conversionUniversal(int deca, int base)
			{
				ArrayList<Integer> bits = new ArrayList<Integer>();
				String resultado = "";
				int cociente = 0;
				int bandera = 0;
				if(deca>=base){
				for (int i = 0; deca >= base; i++) {
				bits.add(deca % base);
				cociente = deca / base;
				deca = cociente;
				}
				bits.add(cociente);
			}else{
				bits.add(deca % base);
			}
				for (int i = bits.size()-1; i != -1; i--) {
					resultado = resultado + Character.forDigit(bits.get(i),base);
				}
				return resultado;
			}
}
