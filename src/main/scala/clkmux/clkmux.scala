package clkmux
import chisel3._
import chisel3.util._
import chisel3.experimental._
import dsptools._
import dsptools.numbers._
class clkmux() extends Module {
    val io = IO( new Bundle { 
            val c0  = Input(Clock())
            val c1  = Input(Clock())
            val co  = Output(Clock())
            val sel = Input(Bool())
        } 
    )
    io.co := Mux(io.sel, io.c0.asUInt.asBool, io.c1.asUInt.asBool).asClock
}

//This gives you verilog
object clkmux extends App {
  chisel3.Driver.execute(args, () => new clkmux() )
}


