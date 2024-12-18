package hust.soict.ict.aims;

import java.util.Scanner;
import hust.soict.ict.aims.media.*;
import hust.soict.ict.aims.store.*;
import hust.soict.ict.aims.cart.*;
import hust.soict.ict.aims.disc.*;

public class Aims
{
    public static Store store = new Store();
    public static Cart cart = new Cart();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        initializeStore();

        while (true)
        {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void showMenu()
    {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore()
    {
        while (true)
        {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void storeMenu()
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void seeMediaDetails()
    {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media != null)
        {
            System.out.println(media);
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    addToCart();
                    break;
                case 2:
                    playMedia();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        else
        {
            System.out.println("Media not found!");
        }
    }

    public static void mediaDetailsMenu()
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void addToCart()
    {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media != null)
        {
            cart.addMedia(media);
            System.out.println("Added to cart. Current number of items in cart: " + cart.getQtyOrdered(media));
        }
        else
        {
            System.out.println("Media not found!");
        }
    }

    public static void playMedia()
    {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media != null)
        {
            media.play();
        }
        else
        {
            System.out.println("Media not found!");
        }
    }

    public static void updateStore()
    {
        System.out.println("Update store options: ");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Choose option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void addMediaToStore()
    {
        System.out.print("Enter media type (1. DVD, 2. CD, 3. Book): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        Media media = null;
        switch (type)
        {
            case 1:
                media = new DigitalVideoDisc(title);
                break;
            case 2:
                media = new CompactDisc(title);
                break;
            case 3:
                media = new Book(title);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }
        store.addMedia(media);
        System.out.println("Media added to store.");
    }

    public static void removeMediaFromStore()
    {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        store.removeMedia(title);
    }

    public static void seeCurrentCart()
    {
        while (true)
        {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void cartMenu()
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterMediasInCart()
    {
        System.out.println("Filter options: ");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.print("Choose filter option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                System.out.print("Enter ID to filter: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter title to filter: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid filter option.");
        }
    }

    public static void sortMediasInCart()
    {
        System.out.println("Sort options: ");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.print("Choose sort option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid sort option.");
        }
    }

    public static void removeMediaFromCart()
    {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        cart.removeMedia(title);
    }

    public static void placeOrder()
    {
        System.out.println("Order has been placed. Your cart is now empty.");
        cart.clearCart();
    }

    public static void initializeStore()
    {
        store.addMedia(new DigitalVideoDisc("The Matrix", 15.99f));
        store.addMedia(new CompactDisc("Best of Jazz", 12.99f));
        store.addMedia(new Book("The Great Gatsby", 9.99f));
    }
}

