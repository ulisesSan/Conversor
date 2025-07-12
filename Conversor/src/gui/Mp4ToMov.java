package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class Mp4ToMov {
    private JTextField inputFileSource;
    private JPanel contentPane ;
    private JLabel labelSource;
    private JButton accept;

    public Mp4ToMov(){

        JFrame frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


//        for i in *.mp4; do
//  # Extract the filename without the extension
//        filename="${i%.mp4}"
//
//  # Use ffmpeg to convert the MP4 audio to WAV
//        ffmpeg -i "$i" -vn -acodec pcm_s16le "${filename}.wav"
//        done
        accept.addActionListener(new ActionListener() {




            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = inputFileSource.getText();
                String[] cmd = {"ffmpeg", "-i", name,"-f","mov",name+"output_file.mov"};
                try {
                    Process process = Runtime.getRuntime().exec(cmd);//; do",
//                    "[ -e \"$i\" ] || continue","filename=\"${i%.mp4}\"","ffmpeg -i \"$i\"","-c:v prores_ks -profile:v 3 -qscale:v 9",
//                    "-c:a pcm_s16le","\"${filename}_prores.mov\"","done"});

                    InputStream is = process.getInputStream();
                    int val;
                    while((val = is.read()) != -1){
                        System.out.print((char)val);
                    }
                    is.close();
                    InputStream errorStream = process.getErrorStream();
                    while((val = errorStream.read()) != -1) {
                        System.err.print((char) val);
                    }
                    errorStream.close();


                    // Esperar a que el proceso termine
                    int exitCode = process.waitFor();
                    System.out.println("Código de salida del script: " + exitCode);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}

//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Arrays;
//
//public class EjecutarScript {
//
//    public static void main(String[] args) {
//        try {
//            // Comando para ejecutar el script.  Asegúrate de que el script tiene permisos de ejecución.
//            Process proceso = Runtime.getRuntime().exec(new String[]{"sh", "-c", "ruta/a/tu/script.sh"});
//
//            // Opcional: Leer la salida del script
//            InputStream is = proceso.getInputStream();
//            int valor;
//            while((valor = is.read()) != -1) {
//                System.out.print((char)valor);
//            }
//            is.close();
//
//            // Opcional: Manejar errores
//            InputStream errorStream = proceso.getErrorStream();
//            while((valor = errorStream.read()) != -1) {
//                System.err.print((char) valor);
//            }
//            errorStream.close();
//
//
//            // Esperar a que el proceso termine
//            int exitCode = proceso.waitFor();
//            System.out.println("Código de salida del script: " + exitCode);
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}