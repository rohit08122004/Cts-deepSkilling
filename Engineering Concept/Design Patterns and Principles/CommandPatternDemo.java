public class CommandPatternDemo {

    // Step 2: Command Interface
    interface Command {
        void execute();
    }

    // Step 5: Receiver Class
    static class Light {
        private String location;

        public Light(String location) {
            this.location = location;
        }

        public void turnOn() {
            System.out.println(location + " light is ON");
        }

        public void turnOff() {
            System.out.println(location + " light is OFF");
        }
    }

    // Step 3: Concrete Commands
    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Step 4: Invoker Class
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            if (command != null) {
                command.execute();
            } else {
                System.out.println("No command assigned!");
            }
        }
    }

    // Step 6: Test the Command Pattern
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
