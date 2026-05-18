package br.com.fiapride.model;

public interface Recarregavel {
    int CARGA_MAXIMA = 100;
    int CARGA_MINIMA = 0;

    void recarregar(int percentual);
}
