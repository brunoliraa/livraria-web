package livraria.livraria.service;

import livraria.livraria.model.Edicao;
import livraria.livraria.model.Venda;
import livraria.livraria.repository.EdicaoRepository;
import livraria.livraria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private EdicaoRepository edicaoRepository;

    List<Edicao> edicaoList = new ArrayList<>();
    Venda venda = new Venda();




    public ModelAndView getCarrinho(){
        ModelAndView modelAndView = new ModelAndView("carrinho");
        modelAndView.addObject("edicoes", edicaoList);
        modelAndView.addObject("valorTotal", venda.getValorTotal());
        return modelAndView;
    }

    public ModelAndView adicionarNoCarrinho(@PathVariable Long id){
        int quantidade =1;
        ModelAndView modelAndView = new ModelAndView("exibirEdicao");
        Edicao edicao = edicaoRepository.findEdicaoById(id);
        int controle =0;
        for(Edicao ed : edicaoList) {
            if (ed.getId() == id) {
                ed.setQuantidade(ed.getQuantidade() + 1);
                venda.setValorTotal(venda.getValorTotal().add(ed.getValor()));
                controle = 1;
                break;
            }
        }
        if(controle==0){
            edicaoList.add(edicao);
//            venda.setValorTotal(new BigDecimal(0));
            venda.setValorTotal(venda.getValorTotal().add(edicao.getValor()));
        }

        modelAndView.addObject("edicao",edicaoRepository.findEdicaoById(id));
        return modelAndView;
    }

    public ModelAndView removeEdicao(Long id){
        Edicao edicao = edicaoRepository.findEdicaoById(id);
        int quantidade =1;
        for(Edicao ed : edicaoList){
            if(ed.getId() ==id){
                quantidade = ed.getQuantidade();
                System.out.println(ed.getQuantidade());
            }
        }
        BigDecimal valorRemovido = edicao.getValor();
        valorRemovido =valorRemovido.multiply(new BigDecimal(quantidade));
        venda.setValorTotal(venda.getValorTotal().subtract(valorRemovido));
        System.out.println(venda.getValorTotal());
        edicao.setQuantidade(0);
        edicaoList.remove(edicao);

        if (venda.getValorTotal().compareTo(BigDecimal.ZERO) < 0) {

            venda.setValorTotal(new BigDecimal(0));
        }
        if(edicaoList.isEmpty()){
            venda.setValorTotal(new BigDecimal(0));
        }
        return getCarrinho();

    }

    public ModelAndView alterarQuantidade(Long id, Integer acao){
        for(Edicao ed: edicaoList){
            if(ed.getId() == id){
                if(acao ==1){
                    ed.setQuantidade(ed.getQuantidade()+1);
                    venda.setValorTotal(venda.getValorTotal().add(ed.getValor()));
                    break;
                }
                else
                    ed.setQuantidade(ed.getQuantidade()-1);
                    venda.setValorTotal(venda.getValorTotal().subtract(ed.getValor()));
                if(ed.getQuantidade()==0){
                    edicaoList.remove(ed);
                }
                if(venda.getValorTotal().compareTo(BigDecimal.ZERO) ==0){
                    venda.setValorTotal(new BigDecimal(0));
                }
                if(venda.getValorTotal().compareTo(BigDecimal.ZERO)<0){
                    venda.setValorTotal(new BigDecimal(0));
                }


                break;
            }
        }
        return getCarrinho();

    }


}
