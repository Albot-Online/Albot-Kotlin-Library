package online.albot.connector

import mu.KotlinLogging
import java.io.*
import java.net.Socket

private val log  = KotlinLogging.logger("AlbotConnection")

class AlbotConnection {
    private val bufferSize = 2048
    private lateinit var reader: BufferedReader
    private lateinit var writer: PrintWriter
    private lateinit var socket: Socket

    constructor(ip: String = "127.0.0.1", port: Int = 4000) {
        try {
            socket = Socket(ip, port)
            socket.receiveBufferSize = bufferSize
            socket.sendBufferSize = bufferSize

            reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            writer = PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())))
        } catch (e: IOException) {
            log.error(e) { "Could not establish TCP connection with Albot server." }
        }
    }

    /**
     * Blocking receive call for new TCP message as raw string.
     * @return response as raw string
     */
    fun receiveMessage(): String? {
        var incomingData: String? = null
        try {
            while((incomingData==reader.readLine())!=null) {
                incomingData = reader.readLine()
            }

        } catch (e: IOException) {
            log.error(e) {  "Could not read message from TCP connection with Albot." }
        }

        return incomingData
    }

    /**
     * Sends the string to the client as a raw string.
     * @param command command to send as raw string
     */
    fun sendCommand(command: String) {
        writer.write(command)
        writer.flush()
    }

    /**
     * Sends the string to the client as a raw string, then makes a blocking receive call for new TCP message.
     * @param command command to send as raw string
     * @return response as raw string
     */
    fun sendCommandReceiveMessage(command: String): String? {
        sendCommand(command)
        return receiveMessage()
    }

    /**
     * Close the TCP connection properly.
     */
    internal fun close() {
        writer.close()
        try {
            reader.close()
            socket.close()
        } catch (e: IOException) {
            log.error(e) {  "Could not close BufferedReader. (TCP)" }
        }
    }

}