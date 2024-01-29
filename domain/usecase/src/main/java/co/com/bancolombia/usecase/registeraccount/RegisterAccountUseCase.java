package co.com.bancolombia.usecase.registeraccount;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class RegisterAccountUseCase {

    private final AccountRepository accountRepository;
    public Mono<Account> register(String name){
        Account account = Account.builder()
                .name(name)
                .build();

        return validation(account)
                .flatMap(text -> service(account))
                .flatMap(text -> accountRepository.createAccount(account));
    }

    private Mono<String> validation(Account account){
        return Mono.just("OK");
    }

    private Mono<String> service(Account account){
        return Mono.just("Service OK");
    }

}
