package com.development.studentapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessageResponse {
    //Aqui vc insere o código http do erro
    private int status;

    //Aqui vc insere um código de erro personalizado de sua api. Ex: ERRO-7237
    private String code;

    //Aqui vc insere uma mensagem detalhando o que aconteceu, mas sem dados sensíveis da sua aplicação, o conteúdo da sua exception nunca deve ir para seu cliente
    private String message;

    //Aqui um título resumido do que aconteceu.
    private String title;

    //Aqui vc insere o tipo. Por exemplo se vc recebeu dados inválidos, coloque "Invalid Request Exception", se foi um erro devido a uma regra de negócio "Bussiness Exception"
    private String type;
}
