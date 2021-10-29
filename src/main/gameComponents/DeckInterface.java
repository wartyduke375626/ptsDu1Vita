package gameComponents;

import java.util.List;

public interface DeckInterface {
    public List<CardInterface> draw(int count);
    public int getSize();
}
