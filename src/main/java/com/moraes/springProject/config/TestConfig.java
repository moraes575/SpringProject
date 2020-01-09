package com.moraes.springProject.config;

import com.moraes.springProject.entidades.Categoria;
import com.moraes.springProject.entidades.Pedido;
import com.moraes.springProject.entidades.Produto;
import com.moraes.springProject.entidades.Usuario;
import com.moraes.springProject.entidades.enums.PedidoStatus;
import com.moraes.springProject.repositories.CategoriaRepository;
import com.moraes.springProject.repositories.PedidoRepository;
import com.moraes.springProject.repositories.ProdutoRepository;
import com.moraes.springProject.repositories.UsuarioRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Eletrônicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        pr1.getCategorias().add(cat2);
        pr2.getCategorias().add(cat1);
        pr2.getCategorias().add(cat3);
        pr3.getCategorias().add(cat3);
        pr4.getCategorias().add(cat3);
        pr5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

    }

}
