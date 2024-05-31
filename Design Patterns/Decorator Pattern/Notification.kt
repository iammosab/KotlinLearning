interface Notification {
    fun send(message:String)
}

class NormalNotification : Notification {
    override fun send(message:String){
        println("Notification: $message")
    }
}

abstract class NotificationDecorator(val decoratedNotification:Notification) : Notification {
    override fun send(message:String){
        decoratedNotification.send(message)
    }
}

class EmailNotificationDecorator(decoratedNotification: Notification) : NotificationDecorator(decoratedNotification) {
    override fun send(message:String){
        super.send(message)
        println("Sending email with message: $message")
    }
}

class LoggingNotificationDecorator(decoratedNotification: Notification) : NotificationDecorator(decoratedNotification) {
    override fun send(message:String){
        super.send(message)
        println("Logging notification: $message")
    }
}

fun main() {
    val n = NormalNotification()
    val en = EmailNotificationDecorator(n)
    val ln = LoggingNotificationDecorator(en)
    
    ln.send("hello")
}