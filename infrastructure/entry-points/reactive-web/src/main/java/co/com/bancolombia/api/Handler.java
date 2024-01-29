package co.com.bancolombia.api;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.usecase.registeraccount.RegisterAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private  final RegisterAccountUseCase registerAccountUseCase;
    //private  final UseCase2 useCase2;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        Mono<Account> register = registerAccountUseCase.register("Juan");
        return ServerResponse.ok().body(register, Account.class);
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
