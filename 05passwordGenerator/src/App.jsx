import { useState ,useCallback,useEffect,useRef} from 'react'



function App() {
  const [length, setlength] = useState(8)
  const[numberAllowed,setNumberAllowed]=useState(false);
  const[charAllowed,setCharAllowed]=useState(false);
  const[Password,setPassword]=useState("")
 
  //useRef Hook
  const passwordfRef=useRef(null)
 
  const passwordGenerator=useCallback(()=>{
    let pass=""
      let str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // fixed here

  if (numberAllowed) str+="0123456789"
  if(charAllowed)str+="!@#$%^&*_+=[]{}~`"
  for(let i=1;i<=length; i++) {
    let char=Math.floor(Math.random()*str.length+1)
    pass+=str.charAt(char
      
    )

  }
setPassword(pass)

  },[length,numberAllowed,charAllowed,setPassword])

//useRef
const copypasswordToClipBoard=useCallback(()=>{
  passwordfRef.current?.select()    //select deselect do
 passwordfRef.current?.setSelectionRange(0,20) //pass not select above20 for copy
  window.navigator.clipboard.writeText(Password)
},[Password])

  useEffect(()=>{
  passwordGenerator()
},[length,numberAllowed,charAllowed,passwordGenerator])
  return (
    <>
      <div className='w-full max-w-md mx-auto shadow-md rounded-lg px-4 py-3 my-8  text-orange-500 bg-gray-300 '>
        <h1 className='text-black text-center my-3'>Pssword Generator</h1>
        <div className='flex shadow rounded-lg overflow-hidden mb-4'>
          <input type="text" value={Password} className='outline-none w-full py-1 px-3' readOnly placeholder='password' ref={passwordfRef}/>
        <button onClick={copypasswordToClipBoard}
         className='ouline-none bg-blue-400 text-white px-3 py-0.5 shrink-0 '>Copy</button>
        </div>
        <div className='flex flex-sm gap-x-2'>
          <div className='flex items-center gap-x-1'>
            <input type="range" name="" id=""
            min={6} max={100} value={length} className='cusrsor-pointer'  onChange={(e)=>{setlength(e.target.value)}}/>
            <label>length: {length}</label>
          </div>
          <div className='flex items-center gap-x-1'>
        <input type="checkbox" defaultChecked={numberAllowed} id="numberInput" onChange={()=>{
          setNumberAllowed((prev)=>!prev)}} />
          <label htmlFor="numberInput">Numbers</label>
                    </div>
<div className='flex items-center gap-x-1'>
   <input type="checkbox" defaultChecked={numberAllowed} id="numberInput" onChange={()=>{
          setNumberAllowed((prev)=>!prev)}} />
<label htmlFor="numberInput">Characters</label>
</div>

        </div>
      </div>

    </>
  )
}

export default App
