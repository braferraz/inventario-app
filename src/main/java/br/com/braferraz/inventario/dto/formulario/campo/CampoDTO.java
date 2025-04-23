package br.com.braferraz.inventario.dto.formulario.campo;

import br.com.braferraz.inventario.model.Template;
import br.com.braferraz.inventario.model.TipoCampo;
import jakarta.persistence.ElementCollection;

import java.time.LocalDate;
import java.util.List;

public class CampoDTO {
    // Informações da pergunta
    private Long id;
    private String nomeCampo;
    private String label;
    private TipoCampo tipoCampo;
    private String placeholder;
    private Boolean obrigatorio;
    private Integer ordem;

    // Validações da pergunta
    private Integer tamanhoMinimo;
    private Integer tamanhoMaximo;
    private String regex;
    private Double valorMinimo;
    private Double valorMaximo;
    private LocalDate dataMinima;
    private LocalDate dataMaxima;

    @ElementCollection
    private List<String> opcoes;     // Para campos tipo SELECT, RADIO, etc.

    private Template template;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TipoCampo getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(TipoCampo tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Boolean getObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(Boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getTamanhoMinimo() {
        return tamanhoMinimo;
    }

    public void setTamanhoMinimo(Integer tamanhoMinimo) {
        this.tamanhoMinimo = tamanhoMinimo;
    }

    public Integer getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(Integer tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public LocalDate getDataMinima() {
        return dataMinima;
    }

    public void setDataMinima(LocalDate dataMinima) {
        this.dataMinima = dataMinima;
    }

    public LocalDate getDataMaxima() {
        return dataMaxima;
    }

    public void setDataMaxima(LocalDate dataMaxima) {
        this.dataMaxima = dataMaxima;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
