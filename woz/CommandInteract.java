import java.util.Scanner;

public class CommandInteract extends BaseCommand implements Command {

    CommandInteract() {
        this.description = "interact with item (1 parameter), example : 'interact sandbag'";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("You inputted to few or to many parameters");
            return;
        }

        Item choosenItem = context.getPlayerInventory().CheckForItem(parameters[0]);

        if (choosenItem == null) {
            System.out.println("that item isn't in your inventory");
            return;
        }
        Space curremtRoom = context.getCurrent();

        Scanner sc = Game.getScanner();

        switch (choosenItem.itemType) {
            case tool:
                if (curremtRoom.getName().equalsIgnoreCase("Field1") || curremtRoom.getName().equalsIgnoreCase("Field2") || curremtRoom.getName().equalsIgnoreCase("Field3")) {

                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
            case sandbags:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                    System.out.print("Do you want to barricade your field with sandbags \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {

                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have barricaded " + curremtRoom.getName() + " with sandbags");
                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to barricade " + curremtRoom.getName() + " with sandbags");
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("invalid choice, Do you want to baricade your field with sandbags \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
            case seeds:
                if(curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")){
                    System.out.print("Do you want to plant: " + choosenItem.name + " in : " + curremtRoom.getName() + "\n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {

                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have planted " + choosenItem.name + " in : "+ curremtRoom.getName());

                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to plant " + choosenItem.name + " in :" + curremtRoom.getName());
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("invalid choice, Do you want to plant" + choosenItem.name + " in : " + curremtRoom.getName() + "\n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }
                }
                break;
            case waterPump:
                if (curremtRoom.getName().equalsIgnoreCase("Well")) {
                    System.out.print("Do you want to install a water pump on your well \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have installed a Water pump on the well");
                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to install a water pump ");
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("invalid choice, Do you want to install a Water pump on the well \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
            case pesticide:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    System.out.print("Do you want to use pesticides against locust swarm?  \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have used pesticide.");
                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to use pesticide ");
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("invalid choice, Do you want to use pesticide? \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }


                }
            case plantPesticide:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    System.out.print("Do you want to use pesticides against plant disease in your farm?  \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have used pesticide.");
                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to pesticide. ");
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("Invalid choice, Do you want to use pesticide? \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }


                }
            case fertilizer:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    System.out.print("Do you want to use fertilizer to enrich the soil?  \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have used fertilizer.");
                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to fertilizer. ");
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("Invalid choice, Do you want to use fertilizer?  \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }


                }
            case antihailnet:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    System.out.print("Do you want to build an anti-hail net?  \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("YES")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        System.out.println("You have build an anti-hail net.");
                    } else if (choice.equalsIgnoreCase("NO")) {
                        System.out.println("You chose not to build an anti-hail net. ");
                    } else {
                        while (!choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("NO")) {
                            System.out.print("Invalid choice, Do you want to build an an anti-hail net? \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }


                }


        }
    }
}
