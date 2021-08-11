package br.com.zup.mercado.livre.ecommerce.produto.imagem;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Set;

public interface Uploader {
    public Set<String> envia(List<MultipartFile> imagens);
}
