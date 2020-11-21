package dev.ivanqueiroz.jbin3dec.main;

import dev.ivanqueiroz.jbin3dec.util.Conversor;
import jexer.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

@Slf4j
@Getter
@Setter
public class App extends TApplication {

    private TField numeroBin;

    public App() throws UnsupportedEncodingException {
        super(BackendType.SWING);
        // Create standard menus for Tool, File, and Window.
        addToolMenu();
        addFileMenu();
        addWindowMenu();
        addBin2DecWindow(this);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.run();
    }

    private void addBin2DecWindow(App app) {
        TWindow window = new TWindow(app, "Bin2Dec", 60, 22);
        window.addLabel("Digite o número binário e pressione enter.", 1, 1);
        final TLabel labelResultado = window.addLabel("", 1, 4);
        setNumeroBin(window.addField(1, 3, 15, false, ""));
        getNumeroBin().setEnterAction(new TAction() {
            @Override public void DO() {

                final TField numeroBinField = (TField) this.source;
                final String numeroBinText = numeroBinField.getText();
                double resultado;
                String mensagem;
                try {
                    resultado = Conversor.bin2dec(numeroBinText);
                    mensagem = "Resultado: " + resultado;
                } catch (IllegalArgumentException e) {
                    log.error("Argumento inválido.");
                    mensagem = "Digite apenas 1 ou 0 !!!!";
                }
                labelResultado.setLabel(mensagem);
            }
        });
    }

}
