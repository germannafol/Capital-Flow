package com.example.demo.job;

import com.example.demo.model.FavoriteStockModel;
import com.example.demo.service.impl.FavoriteStockService;
import com.example.demo.service.impl.ApiStockB3Service;
import com.example.demo.ultils.LogUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// 13 - Implementar threads com o implements do Java
// 14 - DisposableBean - Gerenciamento Dependência
// 15 - Runnable - interface para stacks
// 16 - Obrigatório para esses implements o métod o run e destroy
@Component
public class AcaoThreadJob implements DisposableBean, Runnable {

    private Thread thread;
    private boolean running;

    // 27 - Injetar o service
    @Autowired
    private FavoriteStockService acaoFavoritaService;

    @Autowired
    private ApiStockB3Service apiAcaoB3Service;

    // Constructor para injetar as dependências
    AcaoThreadJob() {
        // 17 - Usando o objeto criado, para instanciar uma nova Thread com o contexto vai ser da classe
        this.thread = new Thread(this);

        // 18 - No constructor a thread vai ser startada pela runnable
        this.thread.start();

        // 19 - Por ser um component, a classe ao ser executada, então por default é true, no ciclo de vida do spring
        running = true;
    }

    //Métod: Início da vida da thread
    @Override
    public void run() {
        // 21 - Valida primeiro o paramêtro de controle antes de startar a thread
        while (running) {
            // 24 - Delay da thread + Try/Catch
            try {
                Thread.sleep(10000);
                // 22 - Executando a regra de negócio enquanto o running estiver true, a cada 10 seg
                // 23 - Regra de Negócio: Apenas buscar as ações favoritas do usuário no nosso banco de dados
                List<FavoriteStockModel> listaAcoes = acaoFavoritaService.listarSemDuplicidade();

                for (FavoriteStockModel favoriteStockModel : listaAcoes) {
                    apiAcaoB3Service.atualizarValorAcao(favoriteStockModel.getCodigo());
                }
            } catch (InterruptedException e) {
                LogUtil.error(e);
            }
        }
    }

    // Métod: Fim da vida da thread
    @Override
    public void destroy() throws Exception {
        // 20 - Desativa o parâmetro boolean
        running = false;
    }
}
