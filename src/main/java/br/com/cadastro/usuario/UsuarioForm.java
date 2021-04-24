package br.com.cadastro.usuario;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioForm {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UsuarioForm(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String cpf, @NotNull LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Usuario converter(){
        return new Usuario(nome, email, cpf, dataNascimento);
    }
}
