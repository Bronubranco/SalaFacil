package Service;

import Entity.Reserva;
import Entity.Usuario;
import Repository.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaService {

    private static List<Usuario> Repository;
    @Autowired
    private static UsuarioRepository repository;

    public static List<Usuario> findAll(){
        return Repository;
    }

    public Usuario saveUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public static Reserva findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario editUsuario(Usuario usuario, long id){
        Usuario oldUser = this.findById(id).getUsuario();

        if(usuario.getCpf() != null){
            oldUser.setCpf(usuario.getCpf());
        }

        oldUser.setId(usuario.getId()!= null ? usuario.getId() : oldUser.getId());
        oldUser.setNome(usuario.getNome() != null ? usuario.getNome() : oldUser.getNome());
        oldUser.setEmail(usuario.getEmail() != null ? usuario.getEmail() : oldUser.getEmail());
        oldUser.setPhone(usuario.getPhone() != null ? usuario.getPhone() : oldUser.getPhone());

        return repository.save(oldUser);
    }

    public void deleteUser(long id){
        repository.deleteById(id);
    }

    public ReservaService() {
    }

    public void deleteReserva(long id) {
    }

    public Reserva editReserva(Reserva reserva, long id) {
        return reserva;
    }

    public List<Reserva> getReservasPorUsuario(Long userId) {
        return List.of();
    }

    public List<Reserva> getReservasPorSala(long salaId) {
        return List.of();
    }

    public Reserva saveReserva(Reserva reserva) {
        return reserva;
    }
}
