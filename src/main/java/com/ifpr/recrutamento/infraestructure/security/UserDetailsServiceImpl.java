package com.ifpr.recrutamento.infraestructure.security;


import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import com.ifpr.recrutamento.infraestructure.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    private AlunoRepository alunoRepository;

    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo e-mail
        AlunoEntity alunoEntity = alunoRepository.findByEmailInstitucional(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return org.springframework.security.core.userdetails.User
                .withUsername(alunoEntity.getEmailInstitucional()) // Define o nome de usuário como o e-mail
                .password(alunoEntity.getSenhaHash()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
