package gaetanomiscio.U5_W1_D4.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long userId) {
        super("La risorsa con id " + userId + " non è stata trovata");
    }
}
